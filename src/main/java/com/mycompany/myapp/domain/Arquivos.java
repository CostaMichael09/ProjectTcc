package com.mycompany.myapp.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "arquivos")
public class Arquivos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "status")
    private String status;
    @Column(name = "type")
    private String type;
    @Column(name = "uploaded_date")
    private LocalDateTime uploadedDate;
    @Column(name = "uploaded_by")
    private String uploadedBy;

    @Lob
    @Column(name = "pdfs", columnDefinition = "BLOB")
    private byte[] pdfs;

    @Lob
    @Column(name = "fotos")
    private byte[] fotos;

    @ManyToOne
    @JoinColumn(name = "empresa_veiculo_id")
    private EmpresaVeiculo empresaVeiculo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getPdfs() {
        return pdfs;
    }

    public void setPdfs(byte[] pdfs) {
        this.pdfs = pdfs;
    }

    public byte[] getFotos() {
        return fotos;
    }

    public void setFotos(byte[] fotos) {
        this.fotos = fotos;
    }

    public EmpresaVeiculo getEmpresaVeiculo() {
        return empresaVeiculo;
    }

    public void setEmpresaVeiculo(EmpresaVeiculo empresaVeiculo) {
        this.empresaVeiculo = empresaVeiculo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getUploadedDate() {
        return uploadedDate;
    }

    public void setUploadedDate(LocalDateTime uploadedDate) {
        this.uploadedDate = uploadedDate;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }
}

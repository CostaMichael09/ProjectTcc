package com.mycompany.myapp.service.dto;

import java.time.LocalDateTime;

public class ArquivosDTO {
    private Long id;
    private String name;
    private String status;
    private String type;
    private LocalDateTime uploadedDate;
    private String uploadedBy;
    private byte[] pdfs;
    private byte[] fotos;
    private Long empresaVeiculoId;

    // Getters and setters for the fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getEmpresaVeiculoId() {
        return empresaVeiculoId;
    }

    public void setEmpresaVeiculoId(Long empresaVeiculoId) {
        this.empresaVeiculoId = empresaVeiculoId;
    }
}

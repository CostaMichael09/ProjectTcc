package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Arquivos;
import com.mycompany.myapp.domain.EmpresaVeiculo;
import com.mycompany.myapp.repository.ArquivosRepository;
import com.mycompany.myapp.service.dto.ArquivosDTO;
import com.mycompany.myapp.service.mapper.ArquivosMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArquivosService {

    private final ArquivosRepository arquivosRepository;
    private final ArquivosMapper arquivosMapper;

    @Autowired
    UserService userService;

    @Autowired
    public ArquivosService(ArquivosRepository arquivosRepository, ArquivosMapper arquivosMapper) {
        this.arquivosRepository = arquivosRepository;
        this.arquivosMapper = arquivosMapper;
    }

    @Transactional
    public ArquivosDTO save(ArquivosDTO arquivosDTO) {
        Arquivos arquivos = arquivosMapper.toEntity(arquivosDTO);
        arquivos = arquivosRepository.save(arquivos);
        return arquivosMapper.toDto(arquivos);
    }

    @Transactional(readOnly = true)
    public List<ArquivosDTO> findAll() {
        List<Arquivos> arquivosList = arquivosRepository.findAll();
        return arquivosList.stream()
            .map(arquivosMapper::toDto)
            .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<ArquivosDTO> findOne(Long id) {
        return arquivosRepository.findById(id).map(arquivosMapper::toDto);
    }

    @Transactional
    public void delete(Long id) {
        arquivosRepository.deleteById(id);
    }

    public void uploadPdf(Long empresaVeiculoId, MultipartFile pdfFile) throws IOException {
        // Crie uma instância de Arquivos
        Arquivos arquivo = new Arquivos();
        arquivo.setName(pdfFile.getOriginalFilename()); // Defina o nome do arquivo
        arquivo.setStatus("Ativo"); // Defina o status, se aplicável
        arquivo.setType("PDF"); // Defina o tipo, se aplicável
        arquivo.setUploadedDate(LocalDateTime.now()); // Defina a data de upload
        arquivo.setUploadedBy("Usuário"); // Defina o usuário que fez o upload
        arquivo.setPdfs(pdfFile.getBytes()); // Defina os bytes do PDF

        // Recupere o objeto EmpresaVeiculo com o ID fornecido e associe-o ao arquivo
        EmpresaVeiculo empresaVeiculo = new EmpresaVeiculo();
        empresaVeiculo.setId(empresaVeiculoId);
        arquivo.setEmpresaVeiculo(empresaVeiculo);

        // Salve o arquivo na tabela de Arquivos
        arquivosRepository.save(arquivo);
    }

    public void uploadImg(Long empresaVeiculoId, MultipartFile imgFile) throws IOException {
        // Crie uma instância de Arquivos
        Arquivos arquivo = new Arquivos();
        arquivo.setName(imgFile.getOriginalFilename()); // Defina o nome do arquivo
        arquivo.setStatus("Ativo"); // Defina o status, se aplicável
        arquivo.setType(imgFile.getContentType()); // Defina o tipo, se aplicável
        arquivo.setUploadedDate(LocalDateTime.now()); // Defina a data de upload
        arquivo.setUploadedBy("Usuário"); // Defina o usuário que fez o upload
        arquivo.setFotos(imgFile.getBytes()); // Defina os bytes da IMG

        // Recupere o objeto EmpresaVeiculo com o ID fornecido e associe-o ao arquivo
        EmpresaVeiculo empresaVeiculo = new EmpresaVeiculo();
        empresaVeiculo.setId(empresaVeiculoId);
        arquivo.setEmpresaVeiculo(empresaVeiculo);

        // Salve o arquivo na tabela de Arquivos
        arquivosRepository.save(arquivo);
    }

    // Método para fazer o download do PDF
    public byte[] downloadPdf(Long idArquivo) {
        // Implemente a lógica para recuperar o arquivo PDF do banco de dados associado ao EmpresaVeiculo com o ID fornecido
        // Use o repositório para recuperar o arquivo PDF e seus bytes
        Optional<Arquivos> arquivo = arquivosRepository.findById(idArquivo);

        if (arquivo.isPresent()) {
            return arquivo.get().getPdfs();
        } else {
            return null; // Ou outro tratamento de erro, se o arquivo não for encontrado
        }
    }
    public List<Arquivos> obterArquivosPdfPorEmpresaVeiculoId(Long empresaVeiculoId) {
        return arquivosRepository.findAllByEmpresaVeiculoIdAndPdfsIsNotNull(empresaVeiculoId);
    }

    public List<Arquivos> obterArquivoImgPorEmpresaVeiculoId(Long empresaVeiculoId) {
        return arquivosRepository.findAllByEmpresaVeiculoIdAndFotosIsNotNull(empresaVeiculoId);
    }

    public void excluirArquivo(Long arquivoId) {
        arquivosRepository.deleteById(arquivoId);
    }

}

package com.mycompany.myapp.process.empresaVeiculoProcess.delegate;

import com.mycompany.myapp.domain.Arquivos;
import com.mycompany.myapp.domain.EmpresaVeiculo;
import com.mycompany.myapp.repository.ArquivosRepository;
import com.mycompany.myapp.service.ArquivosService;
import com.mycompany.myapp.service.EmpresaVeiculoService;
import com.mycompany.myapp.service.dto.EmpresaVeiculoDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;

@Component
public class VerificarDocDelegate implements JavaDelegate {

    private final Logger log = LoggerFactory.getLogger(VerificarDocDelegate.class);

    @Autowired
    private EmpresaVeiculoService empresaVeiculoService;

    @Autowired
    private ArquivosRepository arquivosRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String businessKey = delegateExecution.getBusinessKey();
        String idVeiculo[] = businessKey.split("#");

        Optional<EmpresaVeiculoDTO> empresaVeiculoDTO = empresaVeiculoService.findOne(Long.valueOf(idVeiculo[1]));

        if (empresaVeiculoDTO.isPresent()) {
            Random random = new Random();
            empresaVeiculoDTO.get().setDocRegular(random.nextBoolean());

            if (!empresaVeiculoDTO.get().getDocRegular()) {
                double valorAleatorioMulta = random.nextDouble() * 10000;
                empresaVeiculoDTO.get().setMulta(BigDecimal.valueOf(valorAleatorioMulta));

                Document document = new Document();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                PdfWriter.getInstance(document, baos);

                document.open();
                document.add(new Paragraph("Multa: " + valorAleatorioMulta));
                document.close();

                // Salve o PDF em um arquivo no servidor ou retorne os bytes diretamente
                // Se optar por salvar no servidor, você precisará do caminho do arquivo para carregá-lo mais tarde.
                byte[] pdfBytesFakePDF = baos.toByteArray();
                // Salve os bytes em um arquivo no servidor

                Arquivos arquivo = new Arquivos();
                arquivo.setName("MultaVeiculoPlaca"+empresaVeiculoDTO.get().getPlaca()+"renavam"+empresaVeiculoDTO.get().getRenavam()+".pdf");
                arquivo.setType("pdf");
                arquivo.setUploadedDate(LocalDateTime.now());
                arquivo.setUploadedBy("DetranAPI"); // Defina o usuário apropriado
                arquivo.setPdfs(pdfBytesFakePDF); // Defina o campo de bytes do PDF

                EmpresaVeiculo empresaVeiculo = new EmpresaVeiculo();
                empresaVeiculo.setId(empresaVeiculoDTO.get().getId());
                arquivo.setEmpresaVeiculo(empresaVeiculo);
                // Salve o objeto Arquivos no banco de dados
                arquivosRepository.save(arquivo);

            }

            empresaVeiculoService.save(empresaVeiculoDTO.get());
        } else {
            log.info("Veiculo nao encontrado no VerificarDocDelegate");
        }
    }
}

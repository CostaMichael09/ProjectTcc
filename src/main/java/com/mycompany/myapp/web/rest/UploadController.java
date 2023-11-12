package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.ArquivosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class UploadController {

    private final ArquivosService pdfService;

    @Autowired
    public UploadController(ArquivosService pdfService) {
        this.pdfService = pdfService;
    }

    @PostMapping("/upload/pdf/{empresaVeiculoId}")
    public void uploadPdf(@PathVariable Long empresaVeiculoId, @RequestParam("pdf") MultipartFile pdfFile) throws IOException {
        // Lide com o upload do arquivo PDF aqui
        pdfService.uploadPdf(empresaVeiculoId, pdfFile);
    }

    @PostMapping("/upload/img/{empresaVeiculoId}")
    public void uploadImg(@PathVariable Long empresaVeiculoId, @RequestParam("img") MultipartFile imgFile) throws IOException {
        // Lide com o upload do arquivo PDF aqui
        pdfService.uploadImg(empresaVeiculoId, imgFile);
    }

//    @GetMapping(value = "/download/pdf/{idArquivo}", produces = MediaType.APPLICATION_PDF_VALUE)
//    public @ResponseBody byte[] downloadPdf(@PathVariable Long idArquivo) throws IOException {
//        // Recupere o PDF do banco de dados
//        byte[] pdfData = pdfService.downloadPdf(idArquivo);
//
//        return pdfData;
//    }
}

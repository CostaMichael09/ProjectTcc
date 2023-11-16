package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.domain.Arquivos;
import com.mycompany.myapp.service.ArquivosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/arquivos")
public class ArquivosController {

    @Autowired
    private ArquivosService arquivosService;

    @GetMapping("/empresa-veiculo/pdf/{empresaVeiculoId}")
    public List<Arquivos> obterArquivosPdfPorEmpresaVeiculo(@PathVariable Long empresaVeiculoId) {
        return arquivosService.obterArquivosPdfPorEmpresaVeiculoId(empresaVeiculoId);
    }

    @GetMapping("/empresa-veiculo/img/{empresaVeiculoId}")
    public List<Arquivos> obterArquivosImgPorEmpresaVeiculo(@PathVariable Long empresaVeiculoId) {
        return arquivosService.obterArquivoImgPorEmpresaVeiculoId(empresaVeiculoId);
    }

    @GetMapping("/empresa-veiculo/imgs/{empresaVeiculoId}")
    public List<Arquivos> obterArquivosImgPorEmpresaVeiculos(@PathVariable List<Long> empresaVeiculoId) {
        return arquivosService.obterArquivoImgPorEmpresaVeiculoIds(empresaVeiculoId);
    }

    @DeleteMapping("/{arquivoId}")
    public void excluirArquivo(@PathVariable Long arquivoId) {
        arquivosService.excluirArquivo(arquivoId);
    }
    // Adicione outros métodos, se necessário, para upload e outras operações
}

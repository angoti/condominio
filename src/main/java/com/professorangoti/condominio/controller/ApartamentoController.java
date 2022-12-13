package com.professorangoti.condominio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.professorangoti.condominio.model.Apartamento;
import com.professorangoti.condominio.repository.ApartamentoRepository;
import com.professorangoti.condominio.repository.ImagemRepository;
import com.professorangoti.condominio.repository.ProprietarioRepository;
import com.professorangoti.uploadfiles.storage.StorageService;

@Controller
public class ApartamentoController {

    @Autowired
    private ApartamentoRepository repoApartamento;

    @Autowired
    private ImagemRepository repoImagem;

    @Autowired
    private ProprietarioRepository repoPropietario;
    
    @Autowired
    private StorageService storageService;

    @GetMapping("cad_apto")
    public String formCadastroApartamento(Model model) {
        model.addAttribute("apartamento", new Apartamento());
        model.addAttribute("proprietarios", repoPropietario.findAll());
        return "form_apto";
    }

    @PostMapping("cad_apto")
    public String gravaNovoApartamento(Apartamento apartamento) {
        repoApartamento.save(apartamento);
        return "redirect:/rel_apto";
    }

    @GetMapping("rel_apto")
    public String relatorio(Model model) {
        // Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
        // List<Apartamento> lista = repoApartamento.findAll();
        // Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
        // System.out.println("------------ tempo de execução: " + (timestamp2.getTime()
        // - timestamp1.getTime()));
        // timestamp1 = new Timestamp(System.currentTimeMillis());
        List<Apartamento> lista2 = repoApartamento.findAll2();
        // timestamp2 = new Timestamp(System.currentTimeMillis());
        // System.out.println("=============tempo de execução: " + (timestamp2.getTime()
        // - timestamp1.getTime()));
        model.addAttribute("apartamentos", lista2);
        return "rel_apto";
    }

    @GetMapping("fotos_apto")
    public String exibeFotosDeApartamento(Model model, @RequestParam("id") String id) {
        model.addAttribute("fotos", repoImagem.getImagens(Long.parseLong(id)));
        model.addAttribute("dados", repoApartamento.findById(Long.parseLong(id)));
        return "fotos_apto";
    }

    @GetMapping("excluir_foto")
    public String excluirFoto(@RequestParam("id") String id) {
        repoImagem.delete(Long.parseLong(id));
        // storageService.
        return "redirect:/rel_apto";
    }

}

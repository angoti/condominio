package com.professorangoti.condominio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.professorangoti.condominio.repository.ImagemRepository;
import com.professorangoti.uploadfiles.storage.StorageService;

@Controller
public class FileUploadController {

	private final StorageService storageService;
	private final ImagemRepository imagemRepository;

	public FileUploadController(StorageService storageService, ImagemRepository imagemRepository ) {
		this.storageService = storageService;
		this.imagemRepository = imagemRepository;
	}

	@GetMapping("/upload")
	public String exibeFormUploadFile(Model model, @RequestParam("id") Long id) {
		model.addAttribute("id", id);
		return "uploadForm";
	}

	@PostMapping("/upload")
	public String handleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("id") String id,
			RedirectAttributes redirectAttributes) {
		storageService.store(file);
		imagemRepository.adicionaImagem(Long.parseLong(id), file.getOriginalFilename());
		redirectAttributes.addFlashAttribute("mensagem",
				"Imagem armazenada no servidor:  " + file.getOriginalFilename());
		return "redirect:/rel_apto";
	}
}

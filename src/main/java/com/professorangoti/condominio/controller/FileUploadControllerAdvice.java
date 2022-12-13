package com.professorangoti.condominio.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.professorangoti.uploadfiles.storage.StorageException;
import com.professorangoti.uploadfiles.storage.StorageFileNotFoundException;

@ControllerAdvice
public class FileUploadControllerAdvice {

  @ExceptionHandler(MaxUploadSizeExceededException.class)
  public String handleMaximumUploadSizeExceeded(MaxUploadSizeExceededException exc,
      final RedirectAttributes redirectAttributes) {
    redirectAttributes.addFlashAttribute("mensagem",
        "Imagem não armazenada no servidor. O arquivo não pode exceder 128 KB.");
    return "redirect:/rel_apto";
  }

  @ExceptionHandler(StorageFileNotFoundException.class)
  public String handleStorageFileNotFoundException(StorageFileNotFoundException exc,
      final RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mensagem", exc.getMessage());
        return "redirect:/rel_apto";
      }
      
      @ExceptionHandler(StorageException.class)
      public String handleStorageException(StorageException exc, final RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mensagem", exc.getMessage());
    return "redirect:/rel_apto";
  }
}

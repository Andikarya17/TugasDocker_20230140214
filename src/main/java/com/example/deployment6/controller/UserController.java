package com.example.deployment6.controller;

import com.example.deployment6.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    // Kredensial login (hardcoded untuk praktikum)
    private final String USERNAME = "admin";
    private final String PASSWORD = "20230140214";

    // Penyimpanan data mahasiswa sementara (in-memory)
    private final List<User> daftarMahasiswa = new ArrayList<>(List.of(
            new User("Andika Arya Putra", "20230140214", "Laki-laki")
    ));

    // ========================
    // LOGIN
    // ========================

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return "redirect:/home";
        }

        model.addAttribute("error", "Username atau password salah!");
        return "login";
    }

    // ========================
    // HOME — Daftar Mahasiswa
    // ========================

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("mahasiswaList", daftarMahasiswa);
        return "home";
    }

    // ========================
    // FORM INPUT MAHASISWA
    // ========================

    @GetMapping("/form")
    public String formPage() {
        return "form";
    }

    @PostMapping("/simpan-data")
    public String simpanData(@RequestParam String nama,
                             @RequestParam String nim,
                             @RequestParam("jenis_kelamin") String jenisKelamin) {
        daftarMahasiswa.add(new User(nama, nim, jenisKelamin));
        return "redirect:/home";
    }

    // ========================
    // LOGOUT
    // ========================

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/";
    }
}

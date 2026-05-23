package com.example.cadastro_aluno;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
    private final CadastroAlunoApplication cadastroAlunoApplication;

    HelloController(CadastroAlunoApplication cadastroAlunoApplication) {
        this.cadastroAlunoApplication = cadastroAlunoApplication;
    }

    @GetMapping("/cadastro")
    public String cadastro(
        @RequestParam String nome,
        @RequestParam String curso, 
        @RequestParam String cidade,
        @RequestParam int idade, 
        @RequestParam double nota) {
            String status;
            if (nota >= 7) {    
            status = "Aprovado";
        } else{
           
            status = "Reprovado";
        }

        String classStatus;

         if (nota >= 7) {    
            classStatus = "aprovado";
        } else{
           
            classStatus = "reprovado";
        }

        String maioridade;
        if (idade >= 18) {
            maioridade = "Maior de idade";
        } else {
            maioridade = "Menor de idade";
        }

        return """
        <html>
        <head>
            <title>Resultado</title>
            <link rel = "stylesheet" href="/style.css">
        </head>
        <body>
            <div class="resultado">
            <h1>Cadastro Realizado</h1>
            <p><strong>Nome: </strong>%s</p>
            <p><strong>Curso: </strong>%s</p>
            <p><strong>Cidade: </strong>%s</p>
            <p><strong>Idade: </strong>%d</p>
            <p><strong>Nota: </strong>%.1f</p>
            <p class="%s">%s</p>
            </div>
        </body>
        </html
        """.formatted(
            nome,
            curso,
            cidade,
            idade,
            nota,
            classStatus,
            status
        );
        }
}

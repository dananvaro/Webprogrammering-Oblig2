package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    List<BillettInfo> liste = new ArrayList<>();

    @PostMapping("/leggInn")
    public void leggInn(BillettInfo billettInfo){
       liste.add(billettInfo);

    }

    @GetMapping("/vis")
    public String visListe(){
        System.out.println(liste.size());
        String skrivUt =
            "<table class='table table-striped table-hover'><tr><th>Film </th><th>Antall </th><th>Fornavn </th>" +
                    "<th>Etternavn </th><th>Telefonnr </th><th>Epost </th></tr><br>";
        for(int i = 0; i < liste.size(); i++){

            skrivUt += "<tr><td>" + liste.get(i).getFilm() + "</td>" + "<td>" + liste.get(i).getAntall() +
                    "</td>" + "<td>" + liste.get(i).getFornavn() +
                    "</td>" + "<td>" + liste.get(i).getEtternavn() + "</td>" + "<td>" +
                    liste.get(i).getTelefonnr() + "</td>" + "<td>" + liste.get(i).getEpost() + "</td></tr>";
        }

        return skrivUt;
    }


    @PostMapping("/slett")
    public void slettListe(){

        liste.clear();
    }

}
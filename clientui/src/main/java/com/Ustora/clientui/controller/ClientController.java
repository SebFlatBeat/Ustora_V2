package com.Ustora.clientui.controller;

import com.Ustora.clientui.beans.BookBean;
import com.Ustora.clientui.beans.ReservationBean;
import com.Ustora.clientui.beans.UserBean;
import com.Ustora.clientui.beans.UserRole;
import com.Ustora.clientui.dto.RestResponsePage;
import com.Ustora.clientui.exceptions.NoExtendIfEndBorrowingExceedException;
import com.Ustora.clientui.proxies.BookProxy;
import com.Ustora.clientui.proxies.ReservationProxy;
import com.Ustora.clientui.proxies.UserProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@Controller
public class ClientController {

    @Autowired
    private UserProxy userProxy;

    @Autowired
    private BookProxy bookProxy;

    @Autowired
    private ReservationProxy reservationProxy;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     *
     * @param modelAllBook
     * @param modelPagination
     * @param modelAllBookList
     * @param page
     * @param size
     * @param titre
     * @param modelDistinctTitre
     * @param auteurPrincipalNom
     * @param modelDistinctAuteurNom
     * @param auteurPrincipalPrenom
     * @param modelDistinctAuteurPrenom
     * @param editeur
     * @param modelDistinctEditeur
     * @param anneeEdition
     * @param modelDistinctAnneeEdition
     * @param section
     * @param modelDistinctSection
     * @param isbn
     * @param modelDistinctIsbn
     * @param modelSearchBook
     * @param modelSearchBookPage
     * @param modelPaginationSearchBook
     * @return
     */
    @GetMapping(value = {"/","/index"})
    public String index(Model modelAllBook, Model modelPagination, Model modelAllBookList,
                        @RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam(name = "size", defaultValue = "20") int size,
                        @RequestParam Optional<String> titre, Model modelDistinctTitre,
                        @RequestParam Optional<String> auteurPrincipalNom, Model modelDistinctAuteurNom,
                        @RequestParam Optional<String> auteurPrincipalPrenom, Model modelDistinctAuteurPrenom,
                        @RequestParam Optional<String> editeur, Model modelDistinctEditeur,
                        @RequestParam Optional<String> anneeEdition, Model modelDistinctAnneeEdition,
                        @RequestParam Optional<String> section, Model modelDistinctSection,
                        @RequestParam Optional<String> isbn, Model modelDistinctIsbn,
                        Model modelSearchBook, Model modelSearchBookPage, Model modelPaginationSearchBook
    ) {
        RestResponsePage <BookBean> allBook = bookProxy.allBook(page);
        List<BookBean> allBookList = bookProxy.allBookList();
        modelAllBookList.addAttribute("allBookList",allBookList);
        modelAllBook.addAttribute("allBook",allBook.getContent());
        modelPagination.addAttribute("paginationBook",allBook);

        List<String> titres = bookProxy.findTitre();
        modelDistinctTitre.addAttribute("titres",titres);

        List<String> auteurNoms = bookProxy.findAuteurNom();
        modelDistinctAuteurNom.addAttribute("auteurNoms",auteurNoms);

        List<String> auteurPrenoms = bookProxy.findAuteurPrenom();
        modelDistinctAuteurPrenom.addAttribute("auteurPrenoms", auteurPrenoms);

        List<String> editeurs = bookProxy.findEditeur();
        modelDistinctEditeur.addAttribute("editeurs",editeurs);

        List<String> anneeEditions = bookProxy.findAnneeEdition();
        modelDistinctAnneeEdition.addAttribute("anneeEditions",anneeEditions);

        List<String> sections = bookProxy.findSection();
        modelDistinctSection.addAttribute("sections",sections);

        List<String> isbns = bookProxy.findIsbn();
        modelDistinctIsbn.addAttribute("isbns",isbns);

        List<BookBean> searchBook = bookProxy.allBookList();

        if(titre.isPresent() && !titre.get().isEmpty() && !searchBook.isEmpty()){
            searchBook = bookProxy.searchTitre(titre.get(),searchBook);
        }

        if(auteurPrincipalNom.isPresent() && !auteurPrincipalNom.get().isEmpty()&& !searchBook.isEmpty()){
            searchBook = bookProxy.searchAuteurNom(auteurPrincipalNom.get(),searchBook);
        }
        if(auteurPrincipalPrenom.isPresent() && !auteurPrincipalPrenom.get().isEmpty() && !searchBook.isEmpty()){
            searchBook = bookProxy.searchAuteurPrenom(auteurPrincipalPrenom.get(),searchBook);
        }
        if (editeur.isPresent() && !editeur.get().isEmpty() && !searchBook.isEmpty()){
            searchBook = bookProxy.searchEditeur(editeur.get(),searchBook);
        }
        if(anneeEdition.isPresent() && !anneeEdition.get().isEmpty()  &&  !searchBook.isEmpty()){
            searchBook = bookProxy.searchAnneeEdition(anneeEdition.get(),searchBook);
        }
        if(section.isPresent() && !section.get().isEmpty()  && !searchBook.isEmpty()){
            searchBook = bookProxy.searchSection(section.get(),searchBook);
        }
        if(isbn.isPresent() && !isbn.get().isEmpty()   && !searchBook.isEmpty()){
            searchBook = bookProxy.searchIsbn(isbn.get(),searchBook);
        }
        Sort sort = Sort.by(
                Sort.Order.asc("auteurPrincpalNom")
        );
        Pageable pageable = PageRequest.of(0,20, sort);
        Page<BookBean> searchBookPage = new PageImpl<>(searchBook,pageable,searchBook.size());
        modelSearchBook.addAttribute("searchBook",searchBook);
        modelSearchBookPage.addAttribute("searchBookPage",searchBookPage);
        modelPaginationSearchBook.addAttribute("paginationSearchBook", searchBookPage);
        logger.info("Affichage de la page d'acceuil");
        return "index";
    }

    /**
     *
     * @param modelUserReservation
     * @return
     */
    @GetMapping(value = "/espacePerso")
    public String espacePerso( Model modelUserReservation){
        UserBean currentUser = userProxy.find(SecurityContextHolder.getContext().getAuthentication().getName());
        List<ReservationBean> userReservation = reservationProxy.reservationList(currentUser.getId());
        modelUserReservation.addAttribute("userReservation",userReservation);
        logger.info("Affichage de l'espace personnel");
        return "espacePerso";
    }

    /**
     *
     * @return
     */
    @GetMapping(value = "/register")
    public String register(){

        return "register";
    }

    /**
     *
     * @param userBean
     * @return
     */
    @PostMapping(value = "/registerPost")
    public String registerPost(@ModelAttribute UserBean userBean){
        userBean.grantAuthority(UserRole.USER);
        userProxy.register(userBean);
        return "redirect:/registerSuccess";
    }

    /**
     *
     * @return
     */
    @GetMapping(value = "/registerSuccess")
    public String registerSuccess(){
        return "registerSuccess";
    }

    /**
     *
     * @param bookId
     * @return
     */
    @PostMapping(value = "/save/reservation")
    public String reservation (@RequestParam Long bookId){
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserBean userId = userProxy.find(currentUser.getUsername());
        ReservationBean newReservation = reservationProxy.newReservation(bookId, userId.getId());
        if (newReservation ==null){
            logger.info("Livre déjà en la possession de l'utilisateur");
            return "redirect:/reservationNotDone";
        }else {
            logger.info("Nouvelle reservation de livre enregitrée");
            return "redirect:/reservationSuccess";
        }
    }

    /**
     *
     * @param id
     * @return
     */
    @PostMapping(value = "/delete/reservation")
    public String deleteReservation (@RequestParam Long id){
        reservationProxy.deleteReservation(id);
        logger.info("Reservation effacée");
        return "redirect:/espacePerso";
    }

    /**
     *
     * @param id
     * @return
     */
    @PostMapping(value = "/extend/reservation")
    public String extendReservation (@RequestParam Long id, Model modelError) {
        try {
            reservationProxy.updateReservation(id);
        } catch (Exception exception) {
            exception.printStackTrace();
            if (exception instanceof NoExtendIfEndBorrowingExceedException) {
                String message = exception.getMessage();
                modelError.addAttribute("message", message);
            }
            logger.info("Prolongement de la reservation");
        }
        return "redirect:/espacePerso";
    }

    /**
     *
     * @return
     */
    @GetMapping(value = "reservationSuccess")
    public String reservationSucces(){
        return "reservationSuccess";
    }

    /**
     *
     * @return
     */
    @GetMapping(value = "reservationNotDone")
    public String reservationNotDone(){
        return "reservationNotDone";
    }

}

package com.Ustora.clientui.proxies;

import com.Ustora.clientui.beans.BookBean;
import com.Ustora.clientui.configurations.FeignConfig;
import com.Ustora.clientui.dto.RestResponsePage;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@FeignClient(name = "zuul-server", contextId="bookProxy", configuration= FeignConfig.class, url = "http://localhost:9004")
@RibbonClient(name = "book")
public interface BookProxy {

    /**
     *
     * @param page
     * @return
     */
    @GetMapping(value = "/book/allBook")
    RestResponsePage <BookBean> allBook(@RequestParam int page);

    @GetMapping(value = "/book/find/id")
    Optional<BookBean> findById(@RequestParam Long bookId);

    /**
     *
     * @return
     */
    @GetMapping(value = "/book/allBookList")
    List<BookBean> allBookList();

    /**
     *
     * @return
     */
    @GetMapping(value = "/book/find/titre")
    List<String> findTitre();

    /**
     *
     * @return
     */
    @GetMapping(value = "/book/find/auteurNom")
    List<String> findAuteurNom();

    /**
     *
     * @return
     */
    @GetMapping(value = "/book/find/auteurPrenom")
    List<String> findAuteurPrenom();

    /**
     *
     * @return
     */
    @GetMapping(value = "/book/find/editeur")
    List<String> findEditeur();

    /**
     *
     * @return
     */
    @GetMapping(value = "/book/find/anneeEdition")
    List<String> findAnneeEdition();

    /**
     *
     * @return
     */
    @GetMapping(value = "/book/find/section")
    List<String> findSection();

    /**
     *
     * @return
     */
    @GetMapping(value = "/book/find/isbn")
     List<String> findIsbn();

    /**
     *
     * @param auteurNom
     * @param searchBook
     * @return
     */
    @PostMapping(value = "/book/search/auteurPrincipalNom/{auteurNom}")
    List<BookBean> searchAuteurNom(@PathVariable("auteurNom") String auteurNom, @RequestBody List<BookBean> searchBook);

    /**
     *
     * @param titre
     * @param searchBook
     * @return
     */
    @PostMapping(value = "/book/search/titre/{titre}")
    List<BookBean> searchTitre(@PathVariable("titre") String titre, @RequestBody List<BookBean> searchBook);

    /**
     *
     * @param auteurPrenom
     * @param searchBook
     * @return
     */
    @PostMapping(value = "/book/search/auteurPrincipalPrenom/{auteurPrenom}")
    List<BookBean> searchAuteurPrenom(@PathVariable("auteurPrenom") String auteurPrenom, @RequestBody List<BookBean> searchBook);

    /**
     *
     * @param editeur
     * @param searchBook
     * @return
     */
    @PostMapping(value = "/book/search/editeur/{editeur}")
    List<BookBean> searchEditeur(@PathVariable("editeur") String editeur, @RequestBody List<BookBean> searchBook);

    /**
     *
     * @param anneeEdition
     * @param searchBook
     * @return
     */
    @PostMapping(value = "/book/search/anneeEdition/{anneeEdition}")
    List<BookBean> searchAnneeEdition(@PathVariable("anneeEdition") String anneeEdition, @RequestBody List<BookBean> searchBook);

    /**
     *
     * @param section
     * @param searchBook
     * @return
     */
    @PostMapping(value = "/book/search/section/{section}")
    List<BookBean> searchSection(@PathVariable("section") String section, @RequestBody List<BookBean> searchBook);

    /**
     *
     * @param isbn
     * @param searchBook
     * @return
     */
    @PostMapping(value = "/book/search/isbn/{isbn}")
    List<BookBean> searchIsbn(@PathVariable("isbn") String isbn, @RequestBody List<BookBean> searchBook);
}

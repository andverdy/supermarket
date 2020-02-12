package it.objectmethod.supermarket.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.supermarket.dao.ArticleDao;
import it.objectmethod.supermarket.dao.FamAssortDao;
import it.objectmethod.supermarket.dao.IvaDao;
import it.objectmethod.supermarket.dao.impl.ArticleDaoImpl;
import it.objectmethod.supermarket.dao.impl.FamAssortDaoImpl;
import it.objectmethod.supermarket.dao.impl.IvaDaoImpl;
import it.objectmethod.supermarket.model.Article;
import it.objectmethod.supermarket.model.FamAssort;
import it.objectmethod.supermarket.model.Iva;

@Controller
public class ArticleController {

	@RequestMapping("/getArticles")
	public String getArticles(ModelMap model) {
		List<Article> listArticle = new ArrayList<Article>();
		ArticleDao articleDao = new ArticleDaoImpl();
		listArticle = articleDao.getArticles();

		model.addAttribute("articleList", listArticle);
		return "home";

	}

	@RequestMapping("/formView")
	public String formView(@RequestParam(value = "getCod", required = false) String getCod, ModelMap model) {
		Article article = null;

		if (getCod != null) {
			ArticleDao articleDao = new ArticleDaoImpl();
			article = articleDao.getArticleByCode(getCod);
		}

		List<Iva> listIva;
		List<FamAssort> listFamAssort;

		IvaDao ivaDao = new IvaDaoImpl();
		FamAssortDao fmsDao = new FamAssortDaoImpl();

		listIva = ivaDao.getIva();
		listFamAssort = fmsDao.getFamAssort();

		model.addAttribute("ivaList", listIva);
		model.addAttribute("listFms", listFamAssort);
		model.addAttribute("articleFormRefresh", article);

		return "formIns";
	}

	@RequestMapping("/insArt")
	public String articleIns(@RequestParam("codice") String codArt, @RequestParam("descriz") String descr,
			@RequestParam("pezziCart") Integer pzCart, @RequestParam("iva") Integer iva,
			@RequestParam("fam") Integer fam, ModelMap model) {
		int result = 0;
		String message;

		Article newArticle = new Article();
		newArticle.setCodArt(codArt);
		newArticle.setDescrizione(descr);
		newArticle.setPzCart(pzCart);
		newArticle.setIdIva(iva);
		newArticle.setIdFamAss(fam);

		ArticleDao artDaoImpl = new ArticleDaoImpl();

		if (artDaoImpl.getArticleByCode(newArticle.getCodArt()) != null) {
			result = artDaoImpl.update(newArticle);
		} else {
			result = artDaoImpl.insert(newArticle);
		}

		if (result == 1) {
			message = "INSERIMENTO AVVENUTO CON SUCCESSO!";
		} else {
			message = "ERRORE INSERIMENTO!";
		}

		model.addAttribute("message", message);
		return "forward:/getArticles";
	}

}

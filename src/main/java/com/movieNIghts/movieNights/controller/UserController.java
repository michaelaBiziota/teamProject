/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movieNIghts.movieNights.controller;

import com.movieNIghts.movieNights.authentication.IAuthenticationFacade;

import com.movieNIghts.movieNights.conf.MyUserDetailsService;
import com.movieNIghts.movieNights.conf.UserDetailsImpl;
import com.movieNIghts.movieNights.dao.DaoRoles;
import com.movieNIghts.movieNights.dao.DaoSeenMovies;
import com.movieNIghts.movieNights.dao.DaoUser;
import com.movieNIghts.movieNights.dao.DaoUserAndMovie;
import com.movieNIghts.movieNights.dao.DaoWatchList;
import com.movieNIghts.movieNights.dao.VerificationDao;
import com.movieNIghts.movieNights.emailConfig.EmailService;
import com.movieNIghts.movieNights.model.User;
import com.movieNIghts.movieNights.model.Userandmovie;
import com.movieNIghts.movieNights.model.UserandmoviePK;
import com.movieNIghts.movieNights.repository.UserRepository;
import com.movieNIghts.movieNights.validation.UserValidation;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author bizmi
 */
@Controller
public class UserController {

    @Autowired
    DaoUser du;
    @Autowired
    DaoRoles dr;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    UserValidation uv;
    @Autowired
    MyUserDetailsService ud;
    @Autowired
    UserRepository ur;
    @Autowired
    IAuthenticationFacade authenticationFacade;
    @Autowired
    DaoUserAndMovie dum;
    @Autowired
    DaoSeenMovies sm;
    @Autowired
    DaoWatchList wl;
    @Autowired
    VerificationDao vd;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    EmailService emailService;

    @InitBinder
    private void initBider(final WebDataBinder binder) {
        binder.setValidator(uv);

    }

    @RequestMapping(value = "registerUser", method = RequestMethod.GET)
    public String registerUser(ModelMap mm) {
        User u = new User();
        mm.addAttribute("user", u);

        return "registration";
    }

    @RequestMapping(value = "doRegisterUser", method = RequestMethod.POST)
    public String doRegisterUser(ModelMap mm,HttpServletRequest request, @RequestParam(value = "password") String pass, @ModelAttribute("user") User us, @Valid User user, BindingResult br) {

        if (br.hasErrors()) {
            return "registration";
        } else {
            us.setPassword(passwordEncoder.encode(pass));
            us.setRole(dr.getRole(1));
            us.setEnabled(false);
            du.registration(us);
            String token = UUID.randomUUID().toString();
            vd.createVerificationTokenForUser(us, token);
            mailSender.send(emailService.constructVerificationEmail(getAppUrl(request), request.getLocale(), token, user));
            mm.addAttribute("EmailSent","An email has been sent to activate your account");
        }
        return "login";

    }

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserNameSimple() {
        Authentication authentication = authenticationFacade.getAuthentication();
        return authentication.getName();
    }

    @RequestMapping(value = "/favoriteMovies", method = RequestMethod.GET)
    public String getFavorite(ModelMap mm) {
        UserDetailsImpl userd = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userm = userd.getUser();
        mm.addAttribute("favoriteMovies", dum.findMovieByUserId(userm.getId()));
        return "profile";
    }

    @RequestMapping(value = "/alreadyWatchedMovies", method = RequestMethod.GET)
    public String getAlreadyWatched(ModelMap mm) {
        UserDetailsImpl userd = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userm = userd.getUser();
        mm.addAttribute("seenMovies", sm.findMovieByUserid(userm.getId()));
        return "profile";
    }

    @RequestMapping(value = "/watchList", method = RequestMethod.GET)
    public String watchList(ModelMap mm) {
        UserDetailsImpl userd = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userm = userd.getUser();
        mm.addAttribute("watchlist", wl.findWatchListByUserId(userm.getId()));
        return "profile";
    }

    private String getAppUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }

    @RequestMapping(value = "/activateAccount", method = RequestMethod.GET)
    public String activateAccount(@RequestParam(value = "id") int userid, @RequestParam("token") String token, ModelMap mm) {
        String result = vd.validationVerificationToken(userid, token);
        if (result != null) {
            mm.addAttribute("invalidToken", result);
            return "login";
        } else {
            User validUser = du.findById(userid);
            validUser.setEnabled(true);
            du.registration(validUser);
        }

        return "login";
    }

        @RequestMapping(value = "/getRecommendations", method = RequestMethod.GET)
    public String getRecommendations(ModelMap mm) {
        UserDetailsImpl userd = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userm = userd.getUser();
        mm.addAttribute("favoriteMovies", dum.findMovieByUserId(userm.getId()));
         mm.addAttribute("seenMovies", sm.findMovieByUserid(userm.getId()));
        return "recommendations";
    }
}

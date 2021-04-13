<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import=""%>

<jsp:useBean id="obj" class="org.eni.projetEnchere.dal.UserDAO"/>

<jsp:setProperty name="obj" property="identifiant"/>
<jsp:setProperty name="snr" property="password"/>
<%
    boolean status = UserDAO.validate(obj);

    if(status){
        System.out.println("Connexion réussie");;
        session.setAttribute("session","TRUE");
    }
    else
    {
        System.out.println("Identifiant ou mot de passe erroné");
%>
<jsp:include page="../accueil.jsp"></jsp:include>
<%
    }
%>
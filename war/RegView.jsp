<%-- 
    Document   : Reg
    Created on : 23.01.2013, 11:05:57
    Author     : MorrDeck
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
            <title>NetCracker</title>
            <link href="http://yuliya-sokhrannaya.narod.ru/apple.css" rel="stylesheet" type="text/css">
                </head>
                <body>
                    <div id="top">
                        <table border="0" cellpadding="0" cellspacing="0" width="100%">
                            <tr>
                                <td valign="top">
                                    <img src="http://yuliya-sokhrannaya.narod.ru/logo_netcracker.gif" border="0">
                                </td>
                                <td align="right" valign="top">
                                    Office: +38 048 740 69 96<br />
                                    Mobile: + 38 050 333 40 58<br />
                                    www.NetCracker.comвЂ‚

                                </td>
                                <tr>
                                    </table>

                                    </div>

                                    <ul id="nav">
                                        <li id="list1"><a href=""><span></span></a></li>
                                        <li id="list2"><a href=""><span></span></a></li>
                                        <li id="list3"><a href=""><span></span></a></li>
                                        <li id="list4"><a href=""><span></span></a></li>

                                    </ul>
                                    <br /><br />
                                    <div id="content">
                                        <div id="content-text" align="center">
                                            <spring:nestedPath path="regData">
                                                <form action="" method="post">
                                                    <font size="+1" face="Lucida Grande"><b>
                                                    <table border="0" cellpadding="10" cellspacing="10" align="center" >
                                                        <caption><font size="+2">Регистрационная форма</font></caption>
                                                        <tbody>
                                                            <tr>
                                                                <td align="right">Имя:</td>
                                                                <td><spring:bind path="name">
                                                                        <input type="text" name="${status.expression}" value="${status.value}">
                                                                    </spring:bind></td>
                                                            </tr>
                                                            <tr>
                                                                <td align="right">Фамилия:</td>
                                                                <td><spring:bind path="surname">
                                                                        <input type="text" name="${status.expression}" value="${status.value}">
                                                                    </spring:bind></td>
                                                            </tr>
                                                            <tr>
                                                                <td align="right">E-mail:</td>
                                                                <td><spring:bind path="email">
                                                                        <input type="text" name="${status.expression}" value="${status.value}">
                                                                    </spring:bind></td>
                                                            </tr>
                                                            <tr>
                                                                <td align="right">Пароль:</td>
                                                                <td><spring:bind path="password">
                                                                        <input type="text" name="${status.expression}" value="${status.value}">
                                                                    </spring:bind></td>
                                                                
                                                            </tr>
                            
                                                                <caption align="bottom"><font size="-1">Пароль должен иметь заглавные буквы, строчные буквы и цифры</font></caption>
                                                                <caption align="bottom"><input type="submit" value="Регистрация"></caption>
              
                                                        </tbody>
                                                    </table></b>
                                                    </font>
                                                </form>
                                            </spring:nestedPath>


                                        </div></div>


                                    </body></html>
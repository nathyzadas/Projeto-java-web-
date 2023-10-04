<%@page import="br.com.ProjetoCRUD.dao.ClienteDao"%>
<%@page import="br.com.ProjetoCRUD.entidades.Cliente"%>
<%@page import="br.com.ProjetoCRUD.dao.ContatoDao"%>
<%@page import="br.com.ProjetoCRUD.entidades.Contato"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <!-- - - - - - - - - | CSS | - - - - - - - - -->
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="./css/home.css">
    <link rel="stylesheet" href="./css/home-fale.css">
    <link rel="stylesheet" href="./css/global.css">
    <!-- - - - - - - - - | FONTE | - - - - - - - - -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Kanit:wght@200;300;700;900&family=Montserrat:wght@300;400:500&display=swap" rel="stylesheet">
    <!-- - - - - - - - - | ANIMAÃ‡ÃƒO | - - - - - - - - -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
    <!-- - - - - - - - - | ICONES | - - - - - - - - -->
    <link href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css" rel="stylesheet">
    <!-- - - - - - - - -| ÃCONE | - - - - - - - - -->
    <link href="https://fonts.googleapis.com/css?family=Material+Icons|Material+Icons+Outlined|Material+Icons+Two+Tone|Material+Icons+Round|Material+Icons+Sharp" rel="stylesheet">
    <!-- - - - - - - - - | TÃTULO & ÃCONE HEAD | - - - - - - - - -->
    <title>Fale conosco | FourBarber</title>
    <link rel="icon" type="image/x-icon" href="./images/icon.png">
</head>

<style>
    .img-size{
     width: 400px;
     margin-top: -25%;
    }  
</style>

<body>
    <nav>
        <div class="top-menu" id="menu-topo">
            <div class="display-f align-c justify-bt f-mont f-600 f-20 width-100">
                <div class="logo">
                    <a href="#">
                        <img class="size" src="./images/logo2.png" alt="">
                    </a>
                </div>
                <div>
                    <ul class="display-f align-c">
                        <li><a href="./indexhome.jsp">Home</a></li>
                        <li><a href="./indexhome.jsp#sobre">Sobre Nós</a></li>
                        <li><a href="./home-servicos.jsp">Serviços</a></li>
                        <li><a href="./home-produtos.jsp">Produtos</a></li>
                        <li><a href="https://wa.me/5521990539801?text=Ol%C3%A1%2C+gostaria+de+realizar+um+agendamento.">Agendamento</a></li>
                        <li><a href="./form-faleconosco.jsp">Fale conosco</a></li>
                    </ul>
                </div>
                <div class="button display-f align-c justify-c f-kanit f-700 f-14">
                    <a href="./login.jsp">Login</a>
                </div>
            </div>
        </div>
    </nav>

    <main class="display-f justify-c">
        <div class="card">
            <div class="label-titulo">
                <label class="display-f align-c justify-c f-mont f-900 f-36 color-label">
                    Fale conosco
                </label>
            </div>
            <form method="post" action="ContatoInsertServlet">
                <label class="f-mont f-500 f-18">Email para contato</label>
                <input class="f-mont f-500 f-14 input" type="email" name="emailContato" id="emailContato" placeholder="contato@email.com">

                <br><br>

                <label class="f-mont f-500 f-18">Deixe sua Dúvida</label>
                <br>
                <textarea class="f-mont f-500 f-14 input" rows="5" cols="50" name="txtContato" id="txtContato" placeholder="Escreva sobre sua experiência em nosso estabelecimento."></textarea>

                <br>

                <input onclick="abrirAlerta3()" class="button3 f-mont f-700 f-18" type="submit" value="Enviar">
                
            </form>
        </div>
    </main>



        <!--RodapÃ©-->

        <section class="footer-bg display-f justify-bt upper">
        <div>
            <img class="img-size" src="./images/logopng3.png" alt="">
        </div>
        <div class="color-white">
            <div class="display-f align-c margin-bottom">
                <i class="color-wine ri-map-pin-2-fill icon-margin-r"></i>
                <p class="f-kanit f-700 f-14">Four Barber shop</p>
            </div>
            <br>
            <div>
                <p class="f-kanit f-700 f-14">Rua Cel. Carlos Matos, 86</p>
                <p class="f-kanit f-700 f-14">Centro, Nova Iguaçu/RJ</p>
            </div>
        </div>
 
        <div class="color-white">
            <p class="f-kanit f-700 f-14 margin-bottom">
                <a href="#home">Home</a>
            </p>
            <br>
            <p class="f-kanit f-700 f-14 margin-bottom">
                <a href="#products">Produtos</a>
            </p>
            <br>
            <p class="f-kanit f-700 f-14 margin-bottom">
                <a href="#services">Serviços</a>
            </p>
            <br>
            <p class="f-kanit f-700 f-14 margin-bottom">
                <a href="./form-faleconosco.php">
                    Fale conosco
                </a>
            </p>
        </div>

        <div class="color-white">
            <div class="display-f align-c margin-bottom">
                <i class="color-wine ri-phone-fill icon-margin-r"></i>
                <p class="f-kanit f-700 f-14">(21) 2018-9041</p>
            </div>
            <div class="display-f align-c">
                <i class="color-wine ri-whatsapp-fill icon-margin-r"></i>
                <p class="f-kanit f-700 f-14">(21) 9 8945-6123</p>
            </div>
        </div>

        <div class="color-white">
            <i class="color-wine ri-facebook-fill icon-margin-r"></i>
            <i class="color-wine ri-instagram-fill icon-margin-r"></i>
            <i class="color-wine ri-map-pin-2-fill"></i>
        </div>
    </section>

    <section class="copy display-f justify-c align-c upper">
        <p class="f-kanit f-700 f-14">Copyrigth &copy; FourBarber - 2023. Todos os direitos reservados.</p>
    </section>

    <!--  End -->

    <!-- - - - - - - - -| JQUERY/JS | - - - - - - - - -->
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <!------------ link javascript ---------->
    <script src="./js/script.js"></script>
</body>

</html>
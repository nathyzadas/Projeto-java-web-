<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="br.com.ProjetoCRUD.entidades.Produto" %>
<%@ page import="br.com.ProjetoCRUD.dao.ProdutoDao" %>
<%@ page import="java.util.List" %>



<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Produtos | FourBarber</title>
    <link rel="icon" type="image/x-icon" href="./images/icon.png">
    <!-- - - - - - - - - | CSS | - - - - - - - - -->
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="./css/global.css">
    <link rel="stylesheet" href="./css/home.css">
    <link rel="stylesheet" href="./css/nav.css">
    <link rel="stylesheet" href="./css/conteudo-pag.css">
    <link rel="stylesheet" href="./css/home-produtos.css">
    <link rel="stylesheet" href="./css/teste.css">
    <!-- - - - - - - - - | ANIMAÃÃO | - - - - - - - - -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />
    <!-- - - - - - - - - | ICONES | - - - - - - - - -->
    <link href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css" rel="stylesheet">
    <!-- - - - - - - - - | FONTE | - - - - - - - - -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Kanit:wght@200;300;700;900&family=Montserrat:wght@300;400:500&display=swap" rel="stylesheet">
</head>

<style>
    .img-size{
     width: 400px;
     margin-top: -25%;
    }

    
</style>

<body>
    <div class="over">
        <div class="banner-prod">
            <div class="panel-hero content grid-content">
                <div class="heigth">
                    <div class="area-a">
                        <img class="logo" src="./images/logo2.png" alt="Logo">
                        <div class="margin-title">
                            <div class="panel-title f-kanit f-900 f-70">
                                <p>
                                    Qualidade Inigualável.
                                </p>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="area-b menu f-mont f-600 f-20 display-f align-c" id="menu-lateral">
                    <ul>
                        <li class="hover"><a href="./indexhome.jsp">Home</a></li>
                        <li class="hover"><a href="./indexhome.jsp#sobre">Sobre Nós</a></li>
                        <li class="hover"><a href="./home-servicos.jsp">Serviços</a></li>
                        <li class="hover"><a href="./home-produtos.jsp">Produtos</a></li>
                        <li class="hover"><a href="https://wa.me/5521990539801?text=Ol%C3%A1%2C+gostaria+de+realizar+um+agendamento.">Agendamento</a></li>
                        <li class="hover"><a href="./form-faleconosco.jsp">Fale conosco</a></li>
                        <li class="hover2"><a href="./login.jsp">Login</a></li>

                    </ul>
                </div>

                <nav>
                    <div class="top-menu" id="menu-topo">
                        <div class="display-f align-c justify-bt f-mont f-600 f-20 width-100">
                            <div class="logo">
                                <a href="#">
                                    <img class="size" src="./images/logo2.png" alt="">
                                </a>
                            </div>
                      
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
            </div>
        </div>
    </div>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    
<style>
    .btn-encomenda {
        display: block;
        background-color: red; /* Cor vermelha */
        color: white; /* Cor do texto */
        padding: 10px 20px;
        border-radius: 5px;
        text-decoration: none;
        font-weight: bold;
        transition: background-color 0.3s ease;
        margin: 0 auto; /* Centralizar horizontalmente */
        text-align: center; /* Centralizar o conteúdo do botão */
    }

    .btn-encomenda:hover {
        background-color: darkred; /* Cor mais escura ao passar o mouse */
    }
</style>


<!-- ESTRUTURA DO CARD -->
<div class="content-pagina">
    <div class="content-body">
        <!-- Estrutura que exibe informações dos serviços -->
        <div class="display-f align-c w-100 content-card-content">
            <%
            try {
                ProdutoDao produtoDao = new ProdutoDao();
                List<Produto> listaProduto = produtoDao.listar();

                out.println("Existe: " + listaProduto.size() + " produtos cadastrados");

                for (Produto linha : listaProduto) {
            %>
            <div class="card-pag animate_card">
                <img src="./uploads/<%= linha.getImage() %>"> <!-- Aqui estamos concatenando o caminho com o valor da fotoServico -->
                <div class="content-card">
                    <div class="t-center f-kanit f-900 f-20 upper m-b"><%= linha.getNomeProduto() %></div>
                    <div class="t-center f-mont f-200 f-14">
                        <p><%= linha.getDescricao() %></p>
                    </div>
                    
                    <br>
    <br>
                    <!-- Botão de Encomenda -->
                    <a href="https://api.whatsapp.com/send?phone=SEU_NUMERO_DE_TELEFONE&text=Quero%20encomendar%20o%20produto%20<%= linha.getNomeProduto() %>"
                        class="btn-encomenda">
                        Encomenda
                    </a>
                </div>
            </div>
            <%
                }
            } catch (Exception e) {
                out.println("Erro ao listar os produtos: " + e.getMessage());
            }
            %>
        </div>
    </div>
</div>


    <!-- FIM ESTRUTURA DO CARD -->




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
            <div>
                <p class="f-kanit f-700 f-14">Rua Cel. Carlos Matos, 86</p>
                <p class="f-kanit f-700 f-14">Centro, Nova Iguaçu/RJ</p>
            </div>
        </div>
 
        <div class="color-white">
            <p class="f-kanit f-700 f-14 margin-bottom">
                <a href="#home">Home</a>
            </p>
            <p class="f-kanit f-700 f-14 margin-bottom">
                <a href="#products">Produtos</a>
            </p>
            <p class="f-kanit f-700 f-14 margin-bottom">
                <a href="#services">Serviços</a>
            </p>
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



    <!-- - - - - - - - - | JQUERY/JS | - - - - - - - - -->
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <!------------ link javascript ---------->
    <script src="./js/script.js"></script>
</body>

</html>
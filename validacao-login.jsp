<?php
   require_once("classes/Cliente.php");

    $login = $_POST['txtLogin'];
    $senha = $_POST['txtSenha'];

    if(($login == 'adm') && ($senha == '123')){
        //<- - - - - | Sessão iniciada para o ADMINISTRADOR |- - - - ->
        session_start();
        $_SESSION['lgn-adm'] = $login;
        $_SESSION['snh-adm'] = $senha;
        header("Location: private-adm/info-produto.php");

    } else if ($login != 'adm') {
       
        $cliente = new Cliente();
        $cliente->setEmailCliente($login);
        $cliente->setsenha($senha);
    
        if ($cliente->localizar($cliente)) {
        //session
          session_start();
          $_SESSION['lgn'] = $login;
          header('Location: area-cliente.php'); 

        } else {
          header('Location: login.php');


        } 
      
    
  //  else{
   //     header("Location: /login.php");
 //   }


  // <-------| LOGIN & SENHA -->> ADM
    // LOGIN: adm
    // SENHA: 123
  }

?>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aerolínea</title>
         <jsp:include page="header.jsp" />
    </head>
    <body>
      <div class="container">
          <div class="col-6">
        <form id="form_login"  class="form-signin">
        <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
        <label for="inputEmail" class="sr-only">Usuario</label>
        <input type="text" id="usuario" class="form-control" placeholder="Usuario" required autofocus>
        <label for="inputPassword" class="sr-only">Clave</label>
        <input type="password" id="clave" class="form-control" placeholder="Clave" required>
        <div class="checkbox mb-3">
        </div>
        <button id = "login_button" class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
          </div>
      </div>
        <script>
            
            function cargar (usuario){
                var ws = new WebSocket("ws://localhost:8084/aerolinea/usuario");

                ws.onopen = function(event){
                    ws.send(JSON.stringify(usuario));
                }
                ws.onclose = function(event){
                }

                ws.onmessage = function(event){ 
                    var usu = JSON.parse(event.data);
                    console.log(usu)
                    switch(usu) {
                        case true:
                            document.location = "index.jsp";
                            break;
                        case false:
                            $("#usuario").css("background-color", "pink");
                            $("#clave").css("background-color", "pink");
                            break;
                    }
                }
            }
            
            function loaded(){
                $("#login_button").on("click", () => {
                    if (validate()) {
                        var usuario = {
                        type: "Usuario",
                        username: $("#usuario").val(),
                        clave: $("#clave").val()  
                        };
                        console.log(usuario);
                        //addLogout();
                        cargar(usuario);
                        
                    }
                    return false;
                });

            }

            function validate() {
                var val = true;
                if ($("#usuario").val() === '') {
                    val = false;
                }
                if ($("#clave").val() === '') {
                    val = false;
                }
                return val;
            }


            /*function addLogout() {
                var ul = $("#ul");
                var li = $("<li id = 'li' class='nav-item'>"+
                            "<a id = 'logout' class='nav-link' href='#'><strong>Salir</strong></a>"+
                            "</li>" );
                ul.append(li);
            }*/
            
            $(loaded);
                          
               
              
        </script>
    </body>
</html>

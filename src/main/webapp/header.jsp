<%@page import="Aerolinea.presentation.usuario_WS"%>
<%Boolean empty = usuario_WS.user.isEmpty();%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <script src="js/jquery-3.6.0.min.js"></script>
        <script src="js/jquery.dataTables.min.js"></script>
        
        <link href="css/bootstrap.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

    </head>
    <body>
        <nav class="navbar navbar-expand-lg">

           
        
            <div class="container-fluid navbar navbar-dark bg-dark">
                  <div class="navbar-header">
                        <ul id = "ul" class="navbar-nav ml-auto">
                            
                    <li class="nav-item">        
                <a href="index.jsp"><img src="Imagenes/logo.png" class="logo-brand"  style="width: 50px; height: 50px;"></a>
                </li> 
                
                    <%if(empty){%>
                        <li class="nav-item">
                            <a class="nav-link" href="login.jsp"><strong>Ingresar</strong></a>
                        </li>    

                    <%}%>  
                    <%if(!empty){%>
                        <li class="nav-item">
                            <a id = "logout" class="nav-link" href="#"><strong>Salir</strong></a>
                        </li>    
                    <%}%>   

                        
                        <li class="nav-item">
                            <a class="nav-link" href="vuelos.jsp"><strong>Ver vuelos</strong></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="gestion_tipo_aviones.jsp"><strong>Gestión de tipos de aviones</strong></a>
                        </li>
                    
                       
                   
                        <li class="nav-item">
                            <a class="nav-link" href="gestion_rutas.jsp"><strong>Gestión de rutas</strong></a>
                        </li>
                    
                        <li class="nav-item">
                            <a class="nav-link" href="gestion_horarios.jsp"><strong>Gestión de horarios</strong></a>
                        </li>
                   
                        <li class="nav-item">
                            <a class="nav-link" href="gestion_aviones.jsp"><strong>Gestión de aviones</strong></a>
                        </li>
                    
                        </ul>
                      </div>
                    
<!--                  <ul class="nav navbar-nav navbar-right">
                    
                    <li class="nav-item">
                        <a class="nav-link" href="login.jsp"><span class="glyphicon glyphicon-user"></span> <strong>Admin</strong>
                        </a></li>
                    <li class="nav-item">
                        <a class="nav-link" href="usuario.jsp"><span class="glyphicon glyphicon-log-in"></span><strong>Ingresar</strong>
                    
                        <li class="nav-item">
                        <a id="logout" class="nav-link" href="#"><span class="glyphicon glyphicon-log-in"></span><strong>Salir</strong>
                        </a></li>
                     
                  </ul>-->
    
            </div>
        
        
        
            
    </nav>
    <script>
        function onload(){
            $('#logout').on("click",()=>{ logOut();});
        }
        
        function logOut(){
        var ws = new WebSocket("ws://localhost:8084/aerolinea/salir");

            ws.onopen = function(event){
                ws.send("Salir");
                document.location === "index.jsp" ? location.reload() : document.location = "index.jsp";
            }
            ws.onclose = function(event){
                
            }

            ws.onmessage = function(event){
                
            }
    }
      $(onload());
    </script>
    
    </body>
</html>

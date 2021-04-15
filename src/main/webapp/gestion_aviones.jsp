
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aerolínea</title>
         <jsp:include page="header.jsp" />
         <script src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
    </head>
    <body>
        <div  style="height:70px;">
            <div>Agregar un nuevo avión</div>
                <a>ID</a><input style="width: 200px" type="text" >
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Ruta
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
        <!--                <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another action</a>
                        <a class="dropdown-item" href="#">Something else here</a>-->
                    </div>
                </div>
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Horario
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
        <!--                <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another action</a>
                        <a class="dropdown-item" href="#">Something else here</a>-->
                    </div>
                </div>
                <div class="dropdown">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Tipo de Avión
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
        <!--                <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another action</a>
                        <a class="dropdown-item" href="#">Something else here</a>-->
                    </div>
                </div>
            <button type="button" class="btn btn-dark">Guardar</button>
        
        
        </div>
       
        
    </body>
        <jsp:include page="footer.jsp" />
</html>

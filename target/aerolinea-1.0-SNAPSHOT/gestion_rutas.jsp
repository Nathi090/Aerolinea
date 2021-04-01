
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
<!--        <div  style="height:70px;">
            <div>Agregar nueva ruta</div>
                <a>ID</a><input style="width: 200px" type="text"  placeholder="Salida/Llegada">
                <a>Salida</a><input style="width: 200px" type="text" >
                <a>Llegada</a><input style="width: 200px" type="text" >
                <a>Duración</a><input style="width: 200px" type="text" >
            <button type="button" class="btn btn-dark">Guardar</button>
        
        
        </div>
        -->
        
         <div style= "display: block; overflow: auto;">
                <table id="tabla" class="table table-secondary table-scroll">
                    <thead >
                      <tr class="bg-secondary text-white">
                            <th>ID</th>
                            <th>Salida</th>
                            <th>Llegada</th>
                            <th>Duración</th>
                            <th>Edición</th>
                            
                        </tr>
                    </thead>
                        <tbody>
                    
                    </tbody>
                </table>
                 </div>
        
    </body>
        <jsp:include page="footer.jsp" />
</html>

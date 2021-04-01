
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
        
         <div style= "display: block; overflow: auto;">
                <table id="tabla" class="table table-secondary table-scroll">
                    <thead >
                      <tr class="bg-secondary text-white">
                            <th>ID</th>
                            <th>Año</th>
                            <th>Modelo</th>
                            <th>Marca</th>
                            <th>Pasajeros</th>
                            <th>Filas</th>
                            <th>Asientos/filas</th>
                            
                        </tr>
                    </thead>
                        <tbody>
                   
                    </tbody>
                </table>
                 </div>
        
        
    </body>    
    <jsp:include page="footer.jsp" />
</html>

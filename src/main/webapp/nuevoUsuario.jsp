<%-- 
    Document   : nuevoUsuario
    Created on : 03.03.2019, 19:04:11
    Author     : C.V
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Nuevo Usuario" />
    </jsp:include>
    <body>
        <div class="grid-container">
        <div class="grid-x grid-margin-x align-center">
            <form class="cell small-12 medium-8" action="nuevoanuncio.html" method="post" enctype="multipart/form-data">
                <h4 class="text-center">Ingresa los datos</h4>
                Título del anuncio:<br>
                <input type="text" name="tituloa" value="" placeholder="Ingrese aqui el titulo de su anuncio">
                <br> Precio del articulo:<br>
                <input type="text" name="precioa" value="" placeholder="Ingrese aqui el Precio de su articulo">
                <br> Descripción:
                <br>
                <textarea type="text" name="descripciona" value="" placeholder="Ingrese aqui su descripcion del producto"></textarea>
                <br> Datos técnicos:<br>
                <textarea type="text" name="datostecnicosa" value="" placeholder="ingrese datos tecnicos del producto"></textarea>
                <br> Más información:<br>
                <textarea type="text" name="masinfo" value="" placeholder="que mas decea indicar sobre su producto?"></textarea>
                <br> Categoría:
                <br>
                <select name="subcategoriaa">
                    <optgroup label=categoria1><option value=1>subcategoria1.1</option><option value=2>subcategoria1.2</option><optgroup label=categoria2><option value=4>subcat2.1</option><option value=5>subcat2.2</option><option value=6>subcat2.3</option><option value=7>subcat2.4</option>            </select>
                <br> Ubicación:
                <br>
                <select name="ubicaciona">
                    <option value=1>z1</option><option value=2>z2</option><option value=3>z3</option><option value=4>z4</option><option value=5>z5</option><option value=6>z6</option>            </select>
                <br> Teléfono de contacto:<br>
                <input type="text" name="telefonoa" value="" placeholder="ej: 54638126" pattern="[0-9]+">
                <br> Imagen:
                <br>
                <input type="file" name="image" />
                <br>
                <input class="button small-12 cell" type="submit" name="submit" value="Guardar Anuncio" />
            </form>
        </div>
    </div>

    </body>
    
    
</html>

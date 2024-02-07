SELECT 
lib.LibroId , lib.Libro_Nombre, 
lib.Libro_Costo, lib.Libro_Cantidad, 
gen.Genero_Nombre, edi.Editorial_Nombre, 
idi.Idioma_Nombre
FROM tbl_ope_libro lib 
INNER JOIN tbl_cat_editorial edi ON lib.Libro_EditorialId = edi.EditorialId
INNER JOIN tbl_cat_genero gen ON lib.Libro_GeneroId = gen.GeneroId
INNER JOIN tbl_cat_idioma idi ON lib.Libro_IdiomaId = idi.IdiomaId;

call SeleccionarLibros();

call InsertarLibro();

call ActualizarLibro();

SELECT 
    reg.Id,
    reg.Nombre,
    reg.A_Paterno,
    reg.A_Materno,
    gru.Grupo,
    tur.Turno
 FROM registros reg
inner join tbl_grupo gru on reg.Grupo=gru.Id_Grupo
inner join tbl_turno tur on reg.Turno=tur.Id_Turno;
function cambiar(e,cod,est,cont){
	e.preventDefault();
	console.log(cod);
	console.log(est);
	console.log(cont);
	
	Swal.fire({
	  title: '¿Seguro?',
	  icon: 'warning',
	  showCancelButton: true,
	  confirmButtonColor: '#3085d6',
	  cancelButtonColor: '#d33',
	  confirmButtonText: 'Cambiar',
	  cancelButtonText: "Cancelar",
	}).then((result) => {
	  if (result.isConfirmed) 
		 {
			if(est==true)
			window.setTimeout(function()
			{window.location.href = cont+"Controller?accion=changeEstado&idGenero="+cod+"&es=false"}
			,2000);
			else
			window.setTimeout(function()
			{window.location.href = cont+"Controller?accion=changeEstado&idGenero="+cod+"&es=true"}
			,2000);
			
			Swal.fire({
			  position: 'top-end',
			  icon: 'success',
			  title: 'Se cambio el estado',
			  showConfirmButton: false,
			  timer: 1500
			})

          } else {
                  Swal.fire(
						'Cancelado', 
						'Se cancelo el cambio',
						'ERROR');
                 }
	  
	});
	
	
};

function cambiarCan(e,cod,est,cont){
	e.preventDefault();
	console.log(cod);
	console.log(est);
	console.log(cont);
	
	Swal.fire({
	  title: '¿Seguro?',
	  icon: 'warning',
	  showCancelButton: true,
	  confirmButtonColor: '#3085d6',
	  cancelButtonColor: '#d33',
	  confirmButtonText: 'Cambiar',
	  cancelButtonText: "Cancelar",
	}).then((result) => {
	  if (result.isConfirmed) 
		 {
			if(est==true)
			window.setTimeout(function()
			{window.location.href = cont+"Controller?accion=changeEstado&idCancion="+cod+"&es=false"}
			,2000);
			else
			window.setTimeout(function()
			{window.location.href = cont+"Controller?accion=changeEstado&idCancion="+cod+"&es=true"}
			,2000);
			
			Swal.fire({
			  position: 'top-end',
			  icon: 'success',
			  title: 'Se cambio el estado',
			  showConfirmButton: false,
			  timer: 1500
			})

          } else {
                  Swal.fire(
						'Cancelado', 
						'Se cancelo el cambio',
						'ERROR');
                 }
	  
	});
	
	
};
function revisarBase(event) {
	if ( event.keyCode == 13 ) {
		return false;
	}
	
	return true;
};

function capturarNumero(event) {
	var key = window.event ? event.keyCode : event.which;
	
	if ( key == 48 || key == 49 || key == 50 || key == 51 || key == 52 || 
		 key == 53 || key == 54 || key == 55 || key == 56 || key == 57 ) {
		return true;
	}
	
	return false;
};

function capturarNumeroDecimal(event) {
	var key = window.event ? event.keyCode : event.which;
	
	if ( key == 48 || key == 49 || key == 50 || key == 51 || key == 52 || 
		 key == 53 || key == 54 || key == 55 || key == 56 || key == 57 || 
		 key == 46 ) {
		return true;
	}
	
	return false;
};

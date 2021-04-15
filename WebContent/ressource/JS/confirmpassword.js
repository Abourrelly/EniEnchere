
/////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////// AU CHARGEMENT ////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////////////////////////////////

var inputs = document.querySelectorAll("body div form div div #newPassword, body div form div div #confirmPass");
var notification = document.querySelector("body div form div div.notification p");

// Vérification du mot de passe lors de la saisie

for (var i = 0; i < inputs.length; i++) {
	
	var input = inputs[i];
	
	(function(input) {
		
		input.addEventListener("input", function() {
			
			valid = true;
			
			if (input.value.length < 8) {
				
				notification.innerText = "Votre mot de passe doit comporter au moins 8 chiffres et lettres";
				notification.className = "error";
				valid = false;
				
			} else {
				
				var regex = /["'()[\]{}]/i;
				
				if (regex.test(input.value)) {
					
					notification.innerText = "Les caractères suivants ainsi que les espaces ne sont pas autorisés \" ' ( ) [ ] { }";
					notification.className = "error";
					valid = false;
					
				} else if (inputs[1].value == '') {
					
					notification.innerText = "Veuillez saisir votre mot de passe une seconde fois";
					notification.className = "notif";
					valid = false;
					
				} else if (inputs[0].value != inputs[1].value && inputs[1].value != '') {
					
					notification.innerText = "Les deux mots de passe ne sont pas identiques";
					notification.className = "notif";
					valid = false;
					
				}
				
			}
			
			if (valid) {
				
				notification.innerText = "Votre mot de passe est conforme";
				notification.className = "ok";
				btn.className = "valid";
				
			}
			
		});
		
	}(input));
	
	
}
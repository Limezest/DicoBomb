var Lazy = require("lazy");
var fs = require("graceful-fs");
var unidecode = require('unidecode');
var word;

new Lazy(fs.createReadStream('./Dictionnaire.txt'))
     .lines
     .forEach(function(line){
		 //  Supprime les accents et passe en minuscule :
		 word = unidecode(line.toString().toLowerCase());
		 fs.appendFile("dictionnaire/" + word[0] + ".txt", word + "\n", function(err) {
		    if(err) {
		        return console.log(err, word);
		    }
		}); 
     }
 );
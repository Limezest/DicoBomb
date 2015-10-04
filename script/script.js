var lazy = require("lazy");
var fs = require("graceful-fs");
var word;

new lazy(fs.createReadStream('./Dictionnaire.txt'))
     .lines
     .forEach(function(line){
		 word = line.toString();
		 fs.writeFile("lettres/" + word[0] + ".txt", word, function(err) {
		    if(err) {
		        return console.log(err, word);
		    }
		}); 
     }
 );
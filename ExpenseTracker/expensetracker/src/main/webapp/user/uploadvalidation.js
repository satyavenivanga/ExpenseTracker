var validFileType= "csv";
		function CheckExtension(file){
			var filePath = file.value;
			var ext = filePath.substring(filePath.lastIndexOf('.')+1).toLowerCase();
			var isValidFile = false;

			 for (var i = 0; i < validFileType.length; i++) {
		            if (ext == validFileType) {
		                isValidFile = true;
		                break;
		            }
		        }

			 if (!isValidFile) {
		            file.value = null;
		            alert("Invalid File. Valid extension :" + validFileType);
			}
		}
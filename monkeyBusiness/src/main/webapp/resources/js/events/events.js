     function addProduct()
        {
            color = $("#tablefastCart").css("background-color");
            //$(this).css("background-color", "green");
            $("#tablefastCart").css("background-color", "#C9FF8F");
            
              for(i=0 ; i<1 ; i++) 
              {
                 $("#tablefastCart").fadeTo('slow', 0.5).fadeTo('slow', 1.0, function() {
                        $(this).css("background-color", color);
                    });
                }
        }
        
        function delProduct()
        {
            color = $("#tablefastCart").css("background-color");
           // $(this).css("background-color", "red");
            $("#tablefastCart").css("background-color", "#FF6666");
            
              for(i=0 ; i<1 ; i++) 
              {
                 $("#tablefastCart").fadeTo('slow', 0.5).fadeTo('slow', 1.0, function() {
                        $(this).css("background-color", color);
                    });
                }
        }
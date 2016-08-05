
function barcharts() {
        var chart = new CanvasJS.Chart("chartContainer", {
            title: {
                text: "Transcation details",
                fontFamily: "Verdana",
                fontColor: "Peru",
                fontSize: 28

            },
            animationEnabled: true,
            axisY: {
                tickThickness: 0,
                lineThickness: 0,
                valueFormatString: " ",
                gridThickness: 0                    
            },
            axisX: {
                tickThickness: 0,
                lineThickness: 0,
                labelFontSize: 18,
                labelFontColor: "Peru"

            },
            data: [
            {
                indexLabelFontSize: 26,
                toolTipContent: "<span style='\"'color: {color};'\"'><strong>{indexLabel}</strong></span><span style='\"'font-size: 20px; color:peru '\"'><strong>{y}</strong></span>",

                indexLabelPlacement: "inside",
                indexLabelFontColor: "white",
                indexLabelFontWeight: 600,
                indexLabelFontFamily: "Verdana",
                color: "#62C9C3",
                type: "bar",
                dataPoints: [
                    { y: 21, label: "21%", indexLabel: "Video" },
                    { y: 25, label: "25%", indexLabel: "Dining" },
                    { y: 33, label: "33%", indexLabel: "Entertainment" },
                    { y: 36, label: "36%", indexLabel: "News" },
                    { y: 42, label: "42%", indexLabel: "Music" },
                    { y: 49, label: "49%", indexLabel: "Social Networking" },
                    { y: 50, label: "50%", indexLabel: "Maps/ Search" },
                    { y: 55, label: "55%", indexLabel: "Weather" },
                    { y: 61, label: "61%", indexLabel: "Games" }


                ]
            }
            ]
        });

        chart.render();
    }

	function piecharts(){
		var chart = new CanvasJS.Chart("chartContainer",
				{
					title:{
						text: "Transaction details"
					},
			                animationEnabled: true,
					legend:{
						verticalAlign: "center",
						horizontalAlign: "left",
						fontSize: 20,
						fontFamily: "Helvetica"        
					},
					theme: "theme2",
					data: [
					{        
						type: "pie",       
						indexLabelFontFamily: "Garamond",       
						indexLabelFontSize: 20,
						indexLabel: "{label} {y}%",
						startAngle:-20,      
						showInLegend: true,
						toolTipContent:"{legendText} {y}%",
						dataPoints: [
					                    { y: 21, label: "21%", indexLabel: "Video" },
					                    { y: 25, label: "25%", indexLabel: "Dining" },
					                    { y: 33, label: "33%", indexLabel: "Entertainment" },
					                    { y: 36, label: "36%", indexLabel: "News" },
					                    { y: 42, label: "42%", indexLabel: "Music" },
					                    { y: 49, label: "49%", indexLabel: "Social Networking" },
					                    { y: 50, label: "50%", indexLabel: "Maps/ Search" },
					                    { y: 55, label: "55%", indexLabel: "Weather" },
					                    { y: 61, label: "61%", indexLabel: "Games" }


					                ]
					}
					]
				});
				chart.render();
			}
	
		function linecharts(){
			var chart = new CanvasJS.Chart("chartContainer",
				    {
				      theme: "theme2",
				      title:{
				        text: "Transaction details"
				      },
				      animationEnabled: true,
				      axisX: {
				        valueFormatString: "MMM",
				        interval:1,
				        intervalType: "month"
				        
				      },
				      axisY:{
				        includeZero: false
				        
				      },
				      data: [
				      {        
				        type: "line",
				        //lineThickness: 3,        
				        dataPoints: [
				                     { y: 21, label: "21%", indexLabel: "Video" },
					                    { y: 25, label: "25%", indexLabel: "Dining" },
					                    { y: 33, label: "33%", indexLabel: "Entertainment" },
					                    { y: 36, label: "36%", indexLabel: "News" },
					                    { y: 42, label: "42%", indexLabel: "Music" },
					                    { y: 49, label: "49%", indexLabel: "Social Networking" },
					                    { y: 50, label: "50%", indexLabel: "Maps/ Search" },
					                    { y: 55, label: "55%", indexLabel: "Weather" },
					                    { y: 61, label: "61%", indexLabel: "Games" }
				        
				        ]
				      }
				      
				      
				      ]
				    });

				chart.render();
		}
		
		function areacharts(){
			var chart = new CanvasJS.Chart("chartContainer",
					{
						title: {
							text: "Transaction details"
						},
			                        animationEnabled: true,
						axisX:{      
							valueFormatString: "DD-MMM" ,
							interval: 10,
							intervalType: "day",
							labelAngle: -50,
							labelFontColor: "rgb(0,75,141)",
							minimum: new Date(2012,06,10)
						},
						axisY: {
							title: "Views on YouTube",
							interlacedColor: "#F0FFFF",
							tickColor: "azure",
							titleFontColor: "rgb(0,75,141)",
							valueFormatString: "#M,,.",
							interval: 100000000
						},
						data: [
						{        
							indexLabelFontColor: "darkSlateGray",
							name: 'views',
							type: "area",
							color: "rgba(0,75,141,0.7)",
							markerSize:8,
							dataPoints: [
									{ x: new Date(2012, 06, 18), y: 2000000 }, 
									{ x: new Date(2012, 06, 23), y: 6000000 }, 
									{ x: new Date(2012, 07, 1), y: 10000000, indexLabel:"10m"}, 
									{ x: new Date(2012, 07, 11), y: 21000000 }, 
									{ x: new Date(2012, 07, 23), y: 50000000 }, 
									{ x: new Date(2012, 07, 31), y: 75000000  }, 
									{ x: new Date(2012, 08, 04), y: 100000000, indexLabel:"100m" },
									{ x: new Date(2012, 08, 10), y: 125000000 },
									{ x: new Date(2012, 08, 13), y: 150000000},	
									{ x: new Date(2012, 08, 16), y: 175000000},	
									{ x: new Date(2012, 08, 18), y: 200000000, indexLabel:"200m"},	
									{ x: new Date(2012, 08, 21), y: 225000000},	
									{ x: new Date(2012, 08, 24), y: 250000000},	
									{ x: new Date(2012, 08, 26), y: 275000000},	
									{ x: new Date(2012, 08, 28), y: 302000000, indexLabel:"300m"}
					        
					        ]
						}
						
						]
					});

			chart.render();
			}
		
			function columncharts(){
			    var chart = new CanvasJS.Chart("chartContainer",
			    	    {
			    	      title:{
			    	        text: "Top Oil Reserves"    
			    	      },
			    	      animationEnabled: true,
			    	      axisY: {
			    	        title: "Reserves(MMbbl)"
			    	      },
			    	      legend: {
			    	        verticalAlign: "bottom",
			    	        horizontalAlign: "center"
			    	      },
			    	      theme: "theme2",
			    	      data: [

			    	      {        
			    	        type: "column",  
			    	        showInLegend: true, 
			    	        legendMarkerColor: "grey",
			    	        legendText: "MMbbl = one million barrels",
			    	        dataPoints: [
						                    { y: 21, label: "21%", indexLabel: "Video" },
						                    { y: 25, label: "25%", indexLabel: "Dining" },
						                    { y: 33, label: "33%", indexLabel: "Entertainment" },
						                    { y: 36, label: "36%", indexLabel: "News" },
						                    { y: 42, label: "42%", indexLabel: "Music" },
						                    { y: 49, label: "49%", indexLabel: "Social Networking" },
						                    { y: 50, label: "50%", indexLabel: "Maps/ Search" },
						                    { y: 55, label: "55%", indexLabel: "Weather" },
						                    { y: 61, label: "61%", indexLabel: "Games" }


						                ]
			    	      }   
			    	      ]
			    	    });

			    	    chart.render();
			    	  }
			function doughnutcharts(){
				var chart = new CanvasJS.Chart("chartContainer",
						{
							title:{
								text: "Transaction details"
							},
				                        animationEnabled: true,
							theme: "theme2",
							data: [
							{        
								type: "doughnut",
								indexLabelFontFamily: "Garamond",       
								indexLabelFontSize: 20,
								startAngle:0,
								indexLabelFontColor: "dimgrey",       
								indexLabelLineColor: "darkgrey", 
								toolTipContent: "{y} %", 					

								dataPoints: [
							                    { y: 21, label: "21%", indexLabel: "Video" },
							                    { y: 25, label: "25%", indexLabel: "Dining" },
							                    { y: 33, label: "33%", indexLabel: "Entertainment" },
							                    { y: 36, label: "36%", indexLabel: "News" },
							                    { y: 42, label: "42%", indexLabel: "Music" },
							                    { y: 49, label: "49%", indexLabel: "Social Networking" },
							                    { y: 50, label: "50%", indexLabel: "Maps/ Search" },
							                    { y: 55, label: "55%", indexLabel: "Weather" },
							                    { y: 61, label: "61%", indexLabel: "Games" }


							                ]
							}
							]
						});

						chart.render();
					}
			
			
			

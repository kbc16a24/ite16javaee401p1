var lineChartData = {
    labels : ["1月","2月","3月","4月","5月","6月"],
    datasets : [
      {
        label: "私",
        fillColor : /*"#f2dae8"*/"rgba(242,218,232,0.6)",
        strokeColor : /*"#dd9cb4"*/"rgba(221,156,180,0.6)",
        pointColor : /*"#dd9cb4"*/"rgba(221,156,180,0.6)",
        pointStrokeColor : "#fff",
        pointHighlightFill : "#fff",
        pointHighlightStroke : /*"#dd9cb4"*/"rgba(221,156,180,0.6)",
        data : [67,65,66,70,71,77]
      },
      {
        label: "彼",
        fillColor : /*"#afd0ef"*/"rgba(175,208,239,0.6)",
        strokeColor : /*"#fb7dd8"*/"rgba(143,183,221,0.6)",
        pointColor : /*"#8fb7dd"*/"rgba(143,183,221,0.6)",
        pointStrokeColor : "#fff",
        pointHighlightFill : "#fff",
        pointHighlightStroke : /*"#8fb7dd"*/"rgba(143,183,221,0.6)",
        data : [57,56,55,53,56,49]
      }
    ]

  }

  window.onload = function(){
    var ctx = document.getElementById("chart").getContext("2d");
    window.myLine = new Chart(ctx).Line(lineChartData, {
      responsive: true,
      bezierCurve: false 
    });
  }
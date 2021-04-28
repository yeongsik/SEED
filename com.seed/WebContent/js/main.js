/**
 * 
 */
function isElementUnderBottom(elem , triggerDiff) {
    const { top } =elem.getBoundingClientRect();
    const { innerHeight } =window;
    return top > innerHeight + (triggerDiff || 0);
}

function handleScroll() {
    const elems = document.querySelectorAll('.fade-in');
    elems.forEach(elem => {
        if(isElementUnderBottom(elem, -20)) {
            elem.style.opacity ="0";
            elem.style.transform = 'translateY(100px)';
        } else {
            elem.style.opacity ="1";
            elem.style.transform = 'translateY(0)';
        }
    })
}

window.addEventListener('scroll' , handleScroll);

var slideIndex = 1;
showDivs(slideIndex);

function plusDivs(n) {
  showDivs(slideIndex += n);
}

function showDivs(n) {
  var i;
  var x = document.getElementsByClassName("mySlides");
  if (n > x.length) {slideIndex = 1}
  if (n < 1) {slideIndex = x.length} ;
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";
  }
  x[slideIndex-1].style.display = "block";
}


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


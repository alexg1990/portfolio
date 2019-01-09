
window.onload = function () {
  let navbar = document.getElementById('navbar');
  let navbarOffset = navbar.offsetTop;
  let navHome = document.getElementById('navHome');
  let about = document.getElementById('about');
  let aboutOffset = about.offsetTop - 50;
  let navAbout = document.getElementById('navAbout');
  let portfolio = document.getElementById('portfolio');
  let portfolioOffset = portfolio.offsetTop - 50;
  let navPortfolio = document.getElementById('navPortfolio');
  let contact = document.getElementById('contact');
  let contactOffset = contact.offsetTop - 50;
  let navContact = document.getElementById('navContact');
  window.onscroll = function () {
    if (window.pageYOffset >= navbarOffset) {
      navbar.classList.add('navSticky');
      about.style.marginTop = navbar.offsetHeight + 'px';
    } else {
      navbar.classList.remove('navSticky');
      about.style.marginTop = '0px';
    }
    switch (true) {
      case (window.pageYOffset >= aboutOffset && window.pageYOffset <= portfolioOffset):
        navHome.style.color = 'white';
        navAbout.style.color = '#17BF94';
        navPortfolio.style.color = 'white';
        navContact.style.color = 'white';
        document.getElementById('titleAbout').classList.add('solidAnim');
        break;
      case (window.pageYOffset >= portfolioOffset && window.pageYOffset <= contactOffset):
        navHome.style.color = 'white';
        navAbout.style.color = 'white';
        navPortfolio.style.color = '#17BF94';
        navContact.style.color = 'white';

        break;
      case (window.pageYOffset >= contactOffset):
        navHome.style.color = 'white';
        navAbout.style.color = 'white';
        navPortfolio.style.color = 'white';
        navContact.style.color = '#17BF94';
        break;
      default:
        navHome.style.color = '#17BF94';
        navAbout.style.color = 'white';
        navPortfolio.style.color = 'white';
        navContact.style.color = 'white';
    }
  };
};

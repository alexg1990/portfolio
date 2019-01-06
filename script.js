
var navbar;
var navbarOffset;
var navHome;
var about;
var aboutOffset;
var navAbout;
var portfolio;
var portfolioOffset;
var navPortfolio;
var contact;
var contactOffset;
var navContact;

window.onload = function () {
  navbar = document.getElementById('navbar');
  navbarOffset = navbar.offsetTop;
  navHome = document.getElementById('navHome');
  about = document.getElementById('about');
  aboutOffset = about.offsetTop - 50;
  navAbout = document.getElementById('navAbout');
  portfolio = document.getElementById('portfolio');
  portfolioOffset = portfolio.offsetTop - 50;
  navPortfolio = document.getElementById('navPortfolio');
  contact = document.getElementById('contact');
  contactOffset = contact.offsetTop - 50;
  navContact = document.getElementById('navContact');
};

function stickNavbar () {
  if (window.pageYOffset >= navbarOffset) {
    navbar.classList.add('navSticky');
  } else {
    navbar.classList.remove('navSticky');
  }
  switch (true) {
    case (window.pageYOffset >= aboutOffset && window.pageYOffset <= portfolioOffset):
      navHome.style.color = 'white';
      navAbout.style.color = '#17BF94';
      navPortfolio.style.color = 'white';
      navContact.style.color = 'white';
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
}

window.onscroll = function () { stickNavbar(); };

window.onload = function () {
  let navbar = document.getElementById('navbar');
  let navbarOffset = navbar.offsetTop;

  window.onscroll = function () {
    (window.pageYOffset >= navbarOffset) ? navbar.classList.add('navSticky') : navbar.classList.remove('navSticky');
  };
};

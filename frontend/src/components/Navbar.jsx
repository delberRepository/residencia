const navigationItems = [
  { label: 'Inicio', href: '#inicio' },
  { label: 'Sobre nosotros', href: '#sobre-nosotros' },
  { label: 'Servicios', href: '#servicios' },
  { label: 'Contacto', href: '#contacto' },
]

function Navbar() {
  return (
    <header className="site-header">
      <nav className="navbar" aria-label="Navegacion principal">
        <a className="brand" href="#inicio">
          Domus Universia
        </a>
        <div className="nav-links">
          {navigationItems.map((item) => (
            <a key={item.href} href={item.href}>
              {item.label}
            </a>
          ))}
        </div>
      </nav>
    </header>
  )
}

export default Navbar

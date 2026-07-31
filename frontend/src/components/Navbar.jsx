import { useState } from "react";
import { Menu, X } from "lucide-react";

const navigationItems = [
  { label: "Inicio", href: "#inicio" },
  { label: "Sobre nosotros", href: "#sobre-nosotros" },
  { label: "Servicios", href: "#servicios" },
  { label: "Habitaciones", href: "#espacios" },
  { label: "Contacto", href: "#contacto" },
];

function Navbar() {
  const [menuOpen, setMenuOpen] = useState(false);

  return (
      <header className="site-header">
        <nav className="navbar" aria-label="Navegación principal">
          <a
              className="brand"
              href="#inicio"
              onClick={() => setMenuOpen(false)}
          >
            Domus Universia
          </a>

          <button
              className="menu-button"
              onClick={() => setMenuOpen(!menuOpen)}
              aria-label="Abrir menú"
          >
            {menuOpen ? <X size={28} /> : <Menu size={28} />}
          </button>

          <div className={`nav-links ${menuOpen ? "active" : ""}`}>
            {navigationItems.map((item) => (
                <a
                    key={item.href}
                    href={item.href}
                    onClick={() => setMenuOpen(false)}
                >
                  {item.label}
                </a>
            ))}
          </div>
        </nav>
      </header>
  );
}

export default Navbar;
import heroImage from '../assets/residence-hero.jpg'

function HeroSection() {
  return (
    <section
      id="inicio"
      className="hero-section"
      style={{ backgroundImage: `linear-gradient(90deg, rgba(18, 32, 42, 0.60), rgba(18, 32, 42, 0.42)), url(${heroImage})` }}
    >
      <div className="hero-content">
        <p className="eyebrow">Residencia universitaria</p>
        <h1>Un lugar comodo para estudiar, convivir y sentirte en casa</h1>
        <p className="hero-copy">
          Habitaciones preparadas para el ritmo universitario, zonas comunes cuidadas y un equipo cercano para acompanar tu estancia.
        </p>
        <div className="hero-actions">
          <a className="primary-button" href="#contacto">
            Solicitar informacion
          </a>
          <a className="secondary-button" href="#servicios">
            Ver servicios
          </a>
        </div>
      </div>
    </section>
  )
}

export default HeroSection

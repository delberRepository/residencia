import SectionHeader from './SectionHeader.jsx'
import foto1 from '../assets/hero.png'

const spaces = [
  {
    title: 'Basic',
    features: ['Cama 120x200', 'Zona de estudio', 'Armario Amplio', 'Habitación Exterior'],
    src: foto1,
  },
  {
    title: 'Premium',
    features: ['Cama 150x200', 'Zona de estudio', 'Armario Amplio', 'Habitación Exterior'],
    src:foto2,
  },
]

function SpacesSection() {
  return (
    <section id="espacios" className="section spaces-section">
      <div className="section-inner">
        <SectionHeader
          title="Tus espacios personales"
          description="Dos tipos de habitación con equipamiento funcional, luz natural y todo lo necesario para el día a día universitario."
        />
        <div className="spaces-grid">
          {spaces.map((space) => (
            <article className="space-card" key={space.title}>
              <h3>{space.title}</h3>
              <ul>
                {space.features.map((feature) => (
                  <li key={feature}>{feature}</li>
                ))}
              </ul>
            </article>
          ))}
        </div>
      </div>
    </section>
  )
}

export default SpacesSection

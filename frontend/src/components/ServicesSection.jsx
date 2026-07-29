import SectionHeader from './SectionHeader.jsx'

const services = [
  {
    title: 'Habitaciones equipadas',
    description: 'Espacios privados con mobiliario funcional, almacenamiento y condiciones adecuadas para el descanso y el estudio.',
  },
  {
    title: 'Zonas de estudio',
    description: 'Salas silenciosas y areas compartidas para trabajar solo o preparar proyectos en grupo.',
  },
  {
    title: 'Convivencia y bienestar',
    description: 'Ambientes comunes cuidados, acompanamiento residencial y normas claras para una estancia equilibrada.',
  },
  {
    title: 'Servicios diarios',
    description: 'Gestion practica de solicitudes, mantenimiento y comunicacion directa con el equipo de residencia.',
  },
]

function ServicesSection() {
  return (
    <section id="servicios" className="section services-section">
      <div className="section-inner">
        <SectionHeader
          eyebrow="Servicios"
          title="Todo lo necesario para vivir el curso con estabilidad"
          description="Una estructura pensada para que el estudiante pueda centrarse en su vida academica sin perder comodidad."
        />
        <div className="services-grid">
          {services.map((service) => (
            <article className="service-card" key={service.title}>
              <h3>{service.title}</h3>
              <p>{service.description}</p>
            </article>
          ))}
        </div>
      </div>
    </section>
  )
}

export default ServicesSection

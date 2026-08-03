import SectionHeader from './SectionHeader.jsx'
import {
  BedDouble,
  BookOpen,
  DraftingCompass,
  HeartHandshake,
  ShieldCheck,
  Wrench,
} from 'lucide-react'

const services = [
  {
    title: 'Habitaciones equipadas',
    description: 'Espacios privados con mobiliario funcional, almacenamiento y condiciones adecuadas para el descanso y el estudio.',
    icon: BedDouble,
    tone: 'blue',
  },
  {
    title: 'Zonas de estudio',
    description: 'Salas silenciosas y areas compartidas para trabajar solo o preparar proyectos en grupo.',
    icon: BookOpen,
    tone: 'yellow',
  },
  {
    title: 'Convivencia y bienestar',
    description: 'Ambientes comunes cuidados, acompanamiento residencial y normas claras para una estancia equilibrada.',
    icon: HeartHandshake,
    tone: 'pink',
  },
  {
    title: 'Servicios diarios',
    description: 'Gestion practica de solicitudes, mantenimiento y comunicacion directa con el equipo de residencia.',
    icon: Wrench,
    tone: 'green',
  },
  {
    title: 'Nueva Construcción',
    description: 'Instalaciones a estrenar.',
    icon: DraftingCompass,
    tone: 'coral',
  },
  {
    title: 'Seguridad',
    description: 'Control de acceso 24/7.',
    icon: ShieldCheck,
    tone: 'orange',
  },
]

function ServicesSection() {
  return (
    <section id="servicios" className="section services-section">
      <div className="section-inner">
        <SectionHeader
          /*eyebrow="Servicios"*/
          title="¿Que ofrecemos en nuestra residencia?"
          description="Una estructura pensada para que el estudiante pueda centrarse en su vida academica sin perder comodidad."
        />
        <div className="services-grid">
          {services.map((service) => {
            const Icon = service.icon

            return (
              <article className={`service-card service-card--${service.tone}`} key={service.title}>
                <span className="service-icon" aria-hidden="true">
                  <Icon size={34} strokeWidth={2.3} />
                </span>
                <div className="service-card-content">
                  <h3>{service.title}</h3>
                  <p>{service.description}</p>
                </div>
              </article>
            )
          })}
        </div>
      </div>
    </section>

  )

}

export default ServicesSection

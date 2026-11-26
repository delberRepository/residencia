import SectionHeader from './SectionHeader.jsx'
import studentsImage from '../assets/estudiantes34.png'
import { Dumbbell, Trophy, Waves, LibraryBig } from 'lucide-react'

const stats = [
  { value: '8.400', unit: 'm²', label: 'uso residencial y formativo' },
  { value: '7.500', unit: 'm²', label: 'de zona verde"' },
  { value: '122', unit: '', label: 'habitaciones' },
  { value: '6', unit: '', label: 'aulas completamente equipadas' },
]

const facilities = [
  { label: 'Biblioteca', Icon: LibraryBig },
  { label: 'Piscina', Icon: Waves },
  { label: 'Gimnasio', Icon: Dumbbell },
  { label: 'Instalaciones deportivas', Icon: Trophy },

]

function AboutSection() {
  return (
    <section id="sobre-nosotros" className="section about-section">
      <div className="section-inner about-grid">
        <SectionHeader
            /*eyebrow="Sobre nosotros"*/
          title="Bienvenido a nuestra residencia de estudiantes"
          description="En nuestra residencia ofrecemos un entorno seguro, confortable y cuidadosamente diseñado para favorecer el estudio y el bienestar. Ponemos a disposición de nuestros residentes instalaciones modernas, servicios de calidad y un ambiente tranquilo que les permite concentrarse en su desarrollo académico y personal."
        />

        <figure className="about-image">
          <img src={studentsImage} alt="Estudiantes en la residencia" />
        </figure>

        <div className="highlights">
          <div className="highlights-stats">
            {stats.map((item) => (
                <div className="stat-item" key={item.label}>
                  <strong>
                    {item.value}
                    {item.unit && <small>{item.unit}</small>}
                  </strong>
                  <span>{item.label}</span>
                </div>
            ))}
          </div>

          <div className="highlights-facilities">
            {facilities.map((item) => (
                <div className="facility-item" key={item.label}>
                  <span className="facility-icon" aria-hidden="true">
                    <item.Icon size={44} strokeWidth={1.8} />
                  </span>
                  <span>{item.label}</span>
                </div>
            ))}
          </div>
        </div>

      </div>
    </section>
  )
}

export default AboutSection

import SectionHeader from './SectionHeader.jsx'
import studentsImage from '../assets/estudiantes34.png'

const highlights = [
  { value: '5000', label: 'm2' },
  { value: '60', label: 'Habitaciones' },
  { value: '6', label: 'Salones' },
  { value: '2', label: 'piscinas' },
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
        <div className="highlight-list">
          {highlights.map((item) => (
            <div className="highlight-item" key={item.label}>
              <strong>{item.value}</strong>
              <span>{item.label}</span>
            </div>
          ))}
        </div>
      </div>
    </section>
  )
}

export default AboutSection

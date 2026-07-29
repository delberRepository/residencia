import SectionHeader from './SectionHeader.jsx'

const highlights = [
  { value: '24/7', label: 'Atencion y soporte residencial' },
  { value: '5 min', label: 'Conexion con zonas universitarias' },
  { value: '100%', label: 'Espacios pensados para estudiantes' },
]

function AboutSection() {
  return (
    <section id="sobre-nosotros" className="section about-section">
      <div className="section-inner about-grid">
        <SectionHeader
          eyebrow="Sobre nosotros"
          title="Una residencia con vida academica y ambiente tranquilo"
          description="Cuidamos los detalles que importan en el dia a dia: descanso, estudio, convivencia y una comunicacion clara con residentes y familias."
        />
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

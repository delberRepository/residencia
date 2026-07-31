import dividerLine from '../assets/divider_line_big.svg'

function SectionHeader({ eyebrow, title, description }) {
  return (
    <div className="section-header">
      <p className="eyebrow">{eyebrow}</p>
      <h2>{title}</h2>
      <img className="section-divider" src={dividerLine} alt="" aria-hidden="false" />
      <p>{description}</p>
    </div>
  )
}

export default SectionHeader

package br.net.smi.lancamento.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.net.smi.lancamento.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
	//@Query("SELECT * FROM EMPRESA WHERE LIKE (%NOME%)")
	//List<Empresa> findbyNomeIgnoreCaseContaing(String nome);
	//List<Empresa> findByNomeOrCnpjIgnoreCaseContainig(String nome);

}

import { IAluno } from 'app/entities/backEnd/aluno/aluno.model';
import { areaDoEnem } from 'app/entities/enumerations/area-do-enem.model';

export interface IMeta {
  id: number;
  area?: keyof typeof areaDoEnem | null;
  valor?: number | null;
  metaAluno?: Pick<IAluno, 'id' | 'nome'> | null;
}

export type NewMeta = Omit<IMeta, 'id'> & { id: null };
